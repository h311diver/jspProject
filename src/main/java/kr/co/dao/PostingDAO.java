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

import kr.co.domain.PostingDTO;
import kr.co.domain.PageTO;

public class PostingDAO {

	private DataSource dataFactory;

	public PostingDAO() {

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

	public List<PostingDTO> listPosting() {
		List<PostingDTO> listPosting = new ArrayList<PostingDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM posting ORDER BY repRoot DESC, repStep ASC";
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
				
				

				PostingDTO pdto = new PostingDTO(num, writer, title, null, writeDay, readCnt, repRoot, repStep, repIndent);
				listPosting.add(pdto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return listPosting;

	}

	public void insertPosting(PostingDTO pdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO posting "
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

	public PostingDTO readPosting(int num) {
		PostingDTO pdto = null;
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
			
			if(result ==1 && pdto != null) {
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
		
		
		return pdto;
	}
	
	private int increaseReadCnt(int num, Connection conn) {
		int result=0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE posting SET readCnt = readCnt + 1 WHERE num = ?";
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
	
	
	private PostingDTO selectByNum(int num, Connection conn) {
		PostingDTO pdto = null;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM posting WHERE num = ?";
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
			
				
				
				
				pdto = new PostingDTO(num, writer, title, content, 
						writeDay, readCnt, repRoot, repStep, repIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return pdto;
	}

	public PostingDTO updateuiPosting(int num) {
		PostingDTO pdto = null;
		
		Connection conn = null;
		
		try {
			conn = dataFactory.getConnection();
			
			pdto = selectByNum(num, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, null, conn);
		}
		
		
		return pdto;
	}

	public void updatePosting(PostingDTO pdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE posting "
				+ "SET "
				+ "title = ?, writer = ?, content = ?, writeDay = SYSDATE "
				+ "WHERE "
				+ "num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pdto.getTitle());
			pstmt.setString(2, pdto.getWriter());
			pstmt.setString(3, pdto.getContent());
			pstmt.setInt(4, pdto.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void deletePosting(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM posting WHERE num =?";
		
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

	public void replyPosting(PostingDTO pdto, int pnum) {
		Connection conn = null;
		PostingDTO sdto = null;
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
	
	private int insertReply(Connection conn, PostingDTO sdto, PostingDTO rdto) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO posting "
				+ "(num, title, content, writer, repRoot, repStep, repIndent) "
				+ "VALUES "
				+ "(seq_posting_num.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
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
	
	
	private int updateRepStep(Connection conn, PostingDTO sdto) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE posting SET repStep = repStep + 1 WHERE "
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

	private int getAmount(Connection conn) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM posting";
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
	
	public PageTO pageListPosting(int curPage) {
		PageTO to = new PageTO(curPage);
		List<PostingDTO> pageListPosting = new ArrayList<PostingDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, num, writer, title, writeDay, readCnt, repIndent FROM  "
				+ " (SELECT * FROM posting ORDER BY repRoot desc, repStep asc)) "
				+ " WHERE  "
				+ " rnum >= ? AND rnum <= ? ";
		
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			int amount = getAmount(conn);
			to.setAmount(amount);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repIndent = rs.getInt("repIndent");
				
				PostingDTO pdto = 
				new PostingDTO(num, writer, title, null, writeDay, readCnt, 0, 0, repIndent);
				
				pageListPosting.add(pdto);
			}
			
			to.setListPosting(pageListPosting);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to;
		
	}
	
	private int getSearchAmount(Connection conn, String criteria, String keyWord) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM posting WHERE UPPER(" +criteria+ ") LIKE UPPER(?)";
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

	public PageTO searchPosting(String criteria, String keyword, int curPage) {
		PageTO to = new PageTO(curPage);
		List<PostingDTO> searchPosting = new ArrayList<PostingDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM "
				+ " (SELECT rownum rnum, num, writer, title, writeDay, readCnt, repIndent FROM  "
				+ " (SELECT * FROM posting WHERE UPPER(" +criteria+ ") LIKE UPPER(?) ORDER BY repRoot desc, repStep asc)) "
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
				
				
				PostingDTO pdto = 
				new PostingDTO(num, writer, title, null, writeDay, readCnt, 0, 0, repIndent);
				
				searchPosting.add(pdto);
			}
			to.setListPosting(searchPosting);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to;
	}
	
	


}
