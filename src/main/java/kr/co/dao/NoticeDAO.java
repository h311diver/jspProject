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


import kr.co.domain.NoticeDTO;


public class NoticeDAO {
	
	
	private DataSource dataFactory;

	public NoticeDAO() {

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

	public List<NoticeDTO> listNotice() {
		List<NoticeDTO> listNotice = new ArrayList<NoticeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT * FROM notice WHERE rownum < 4 ORDER BY num DESC";
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
				
				

				NoticeDTO ndto = new NoticeDTO(num, writer, title, null, writeDay, readCnt);
				listNotice.add(ndto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return listNotice;

	}

	public void insertNotice(NoticeDTO ndto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO notice "
				+ " ( num, writer, title, content ) "
				+ " VALUES "
				+ " (seq_notice_num.NEXTVAL, ?, ?, ?)";
		
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ndto.getWriter());
			pstmt.setString(2, ndto.getTitle());
			pstmt.setString(3, ndto.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	public NoticeDTO readNotice(int num) {
		NoticeDTO pdto = null;
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
		String sql = "UPDATE notice SET readCnt = readCnt + 1 WHERE num = ?";
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
	
	
	private NoticeDTO selectByNum(int num, Connection conn) {
		NoticeDTO ndto = null;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM notice WHERE num = ?";
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
			
			
				
				
				
				ndto = new NoticeDTO(num, writer, title, content, 
						writeDay, readCnt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return ndto;
	}

	public NoticeDTO updateuiNotice(int num) {
		NoticeDTO ndto = null;
		
		Connection conn = null;
		
		try {
			conn = dataFactory.getConnection();
			
			ndto = selectByNum(num, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, null, conn);
		}
		
		
		return ndto;
	}

	public void updateNotice(NoticeDTO ndto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE notice "
				+ "SET "
				+ "title = ?, writer = ?, content = ?, writeDay = SYSDATE "
				+ "WHERE "
				+ "num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ndto.getTitle());
			pstmt.setString(2, ndto.getWriter());
			pstmt.setString(3, ndto.getContent());
			pstmt.setInt(4, ndto.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void deleteNotice(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM notice WHERE num =?";
		
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
