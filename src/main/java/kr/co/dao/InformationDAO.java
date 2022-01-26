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

import kr.co.domain.InformationDTO;
import kr.co.domain.PageTO;

public class InformationDAO {
	
	private DataSource dataFactory;

	public InformationDAO() {

		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<InformationDTO> list() {
		List<InformationDTO> listInformation = new ArrayList<InformationDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM information ORDER BY repRoot DESC, repStep ASC";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				

				InformationDTO pdto = new InformationDTO(num, writer, title, null, writeDay, readCnt, repRoot, repStep, repIndent);
				listInformation.add(pdto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return listInformation;

	}

	public void insertInformation(InformationDTO pdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO information "
				+ " (num, writer, title, content, repRoot, repStep, repIndent) "
				+ " VALUES "
				+ " (seq_posting_num.NEXTVAL, ?, ?, ?, seq_posting_num.CURRVAL, 0, 0)";
		
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pdto.getWriter());
			pstmt.setString(2, pdto.getTitle());
			pstmt.setString(3, pdto.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}
	

	public PageTO pageListInformation(int curPage) {
		PageTO to = new PageTO(curPage);
		List<InformationDTO> pageListInformation = new ArrayList<InformationDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, num, writer, title, writeDay, readCnt, repIndent FROM  "
				+ " (SELECT * FROM information ORDER BY repRoot desc, repStep asc)) "
				+ " WHERE  "
				+ " rnum >= ? AND rnum <= ? ";
		
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			int amount = getInformationAmount(conn);
			to.setAmount(amount);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repIndent = rs.getInt("repIndent");
				
				InformationDTO pdto = new InformationDTO(num, writer, title, null, writeDay, readCnt, 0, 0, repIndent);
				pageListInformation.add(pdto);
			}
			to.setListInformation(pageListInformation);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return to;
	}

	private int getInformationAmount(Connection conn) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM information";
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

	
	
	
	
	
	
	
	
	
	
	
	/* 메서드 추가 */
	private int getSearchAmount(Connection conn, String criteria, String keyWord) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM information WHERE UPPER(" +criteria+ ") LIKE UPPER(?)";
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
	
	
	
	
	

	public PageTO searchInformation(String criteria, String keyword, int curPage) {
		PageTO to = new PageTO(curPage);
		List<InformationDTO> searchInformation = new ArrayList<InformationDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, num, writer, title, writeDay, readCnt, repIndent FROM  "
				+ " (SELECT * FROM information WHERE UPPER(" +criteria+ ") LIKE UPPER(?) ORDER BY repRoot desc, repStep asc)) "
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
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repIndent = rs.getInt("repIndent");
				
				
				InformationDTO pdto = 
				new InformationDTO(num, writer, title, null, writeDay, readCnt, 0, 0, repIndent);
				
				searchInformation.add(pdto);
			}
			to.setListInformation(searchInformation);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to;
	}

	public void replyInformation(InformationDTO pdto, int pnum) {
		Connection conn = null;
		InformationDTO sdto = null;
		int result_insert = -1;
		int result_update = -1;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			sdto = selectByNum(pnum, conn);
			result_update = updateRepStep(conn, sdto);
			result_insert = insertReply(conn, sdto, pdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sdto != null && result_insert*result_update==1) {
				try {
					conn.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			closeAll(null, null, conn);
		}
		
	}
	
	private InformationDTO selectByNum(int num, Connection conn) {
		InformationDTO pdto = null;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM information WHERE num = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
			
				
				
				
				pdto = new InformationDTO(num, writer, title, content, 
						writeDay, readCnt, repRoot, repStep, repIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return pdto;
	}
	
	private int updateRepStep(Connection conn, InformationDTO sdto) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE information SET repStep = repStep + 1 WHERE "
				+ "repRoot = ? AND repStep > ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sdto.getRepRoot());
			pstmt.setInt(2, sdto.getRepStep());
			
			pstmt.executeUpdate();
			
			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
		return result;
	}
	
	private int insertReply(Connection conn, InformationDTO sdto, InformationDTO rdto) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO information "
				+ "(num, title, content, writer, repRoot, repStep, repIndent) "
				+ "VALUES "
				+ "(seq_information_num.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rdto.getTitle());
			pstmt.setString(2, rdto.getContent());
			pstmt.setString(3, rdto.getWriter());
			
			pstmt.setInt(4, sdto.getRepRoot());
			pstmt.setInt(5, sdto.getRepStep()+1);
			pstmt.setInt(6, sdto.getRepIndent()+1);
			
			pstmt.executeUpdate();
			
			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
		return result;
	}
	
	public InformationDTO readInformation(int num) {
		InformationDTO pdto = null;
		int result = 1;

		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);

			increaseReadCnt(num, conn);

			pdto = selectByNum(num, conn);

			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {

			if (result == 1 && pdto != null) {
				try {
					conn.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeAll(null, null, conn);
		}

		return pdto;
	}
	
	
	private int increaseReadCnt(int num, Connection conn) {
		int result=0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE information SET readCnt = readCnt + 1 WHERE num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
		return result;
	}
	

	public InformationDTO updateuiInformation(int num) {
		InformationDTO idto = null;

		Connection conn = null;

		try {
			conn = dataFactory.getConnection();

			idto = selectByNum(num, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, null, conn);
		}

		return idto;
	}

	public void updateNotice(InformationDTO idto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE information "
				+ "SET "
				+ "title = ?, writer = ?, content = ?, writeDay = SYSDATE "
				+ "WHERE "
				+ "num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, idto.getTitle());
			pstmt.setString(2, idto.getWriter());
			pstmt.setString(3, idto.getContent());
			pstmt.setInt(4, idto.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void deleteInformation(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM information WHERE num =?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
