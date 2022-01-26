package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		
			try {
				Context ctx = new InitialContext();
				dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
			} catch (NamingException e) {
				e.printStackTrace();
			}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertMember(MemberDTO mdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id, pw, name, birthday, address, gender, email, phone, role) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getBirthday());
			pstmt.setString(5, mdto.getAddress());
			pstmt.setString(6, mdto.getGender());
			pstmt.setString(7, mdto.getEmail());
			pstmt.setInt(8, mdto.getPhone());
			pstmt.setString(9, mdto.getRole());
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public List<MemberDTO> listMember() {

		List<MemberDTO> listMember = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member ORDER BY role DESC";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String role = rs.getString("role");
				
				MemberDTO mdto = new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role);
				listMember.add(mdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return listMember;
	}

	public MemberDTO readMember(String id) {
		MemberDTO mdto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String role = rs.getString("role");
				mdto = new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		
		return mdto;
	}

	public MemberDTO updateui(String id) {
		return readMember(id);
	}

	public void updateMember(MemberDTO mdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	    String sql = "UPDATE member SET pw=?, name=?, birthday=?, address=?, gender=?, email=?, phone=?, role=? WHERE id=?" ;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getPw());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getBirthday());
			pstmt.setString(4, mdto.getAddress());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getEmail());
			pstmt.setInt(7, mdto.getPhone());
			pstmt.setString(8, mdto.getRole());
			pstmt.setString(9, mdto.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void deleteMember(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "DELETE FROM member WHERE id = ? AND pw = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		
		
		
	}

	public MemberDTO loginMember(String id, String pw) {
		MemberDTO login = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String role = rs.getString("role");
				login = new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return login;
	}

	
	public MemberDTO readSimpleMember(String id) {
		MemberDTO mdto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String role = rs.getString("role");
				mdto = new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		
		return mdto;
	}
	
	
	
	public PageTO pageListMember(int curPage) {
		PageTO to1 = new PageTO(curPage);
		List<MemberDTO> pageListMember = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, id, pw, name, birthday, address, gender, email, phone, role FROM  "
				+ " (SELECT * FROM member ORDER BY role DESC)) "
				+ " WHERE  "
				+ " rnum >= ? AND rnum <= ? ";
		
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			int amount = getAmount(conn);
			to1.setAmount(amount);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, to1.getStartNum());
			pstmt.setInt(2, to1.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String role = rs.getString("role");
				
				MemberDTO mdto = 
				new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role);
				
				pageListMember.add(mdto);
			}
			
			to1.setListMember(pageListMember);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to1;
		
	}
	
	private int getAmount(Connection conn) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM member";
		ResultSet rs =null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				amount = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return amount;
		
	}
	private int getSearchAmount(Connection conn, String criteria, String keyWord) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM member WHERE UPPER(" +criteria+ ") LIKE UPPER(?)";
		ResultSet rs =null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyWord+"%");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				amount = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return amount;
		
	}
	
	
	
	
	
	
	
	

	public PageTO searchMember(String criteria, String keyword, int curPage) {
		PageTO to = new PageTO(curPage);
		List<MemberDTO> searchMember = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, id, name, role FROM  "
				+ " (SELECT * FROM member WHERE UPPER(" +criteria+ ") LIKE UPPER(?) )) "
				+ " WHERE  "
				+ " rnum >= ? AND rnum <= ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			int search = getSearchAmount(conn, criteria, keyword);
			to.setAmount(search);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, to.getStartNum());
			pstmt.setInt(3, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String role = rs.getString("role");
				
				
				MemberDTO pdto = 
				new MemberDTO(id, null, name, null, null, null, null, 0, role);
				
				searchMember.add(pdto);
			}
			to.setListMember(searchMember);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to;
	}
		
	public int myCountMember(String id) {
		int amount = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM posting p, member m WHERE p.writer = m.id AND id = ?";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return amount;
	}

	public void updateRoleMember(MemberDTO mdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	    String sql = "UPDATE member SET role=? WHERE id=?" ;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, mdto.getRole());
			pstmt.setString(2, mdto.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	
	}
	


















