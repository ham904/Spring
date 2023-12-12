package com.ysboards.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ysboards.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDAO2 {
	
	private final JdbcTemplate jdbcTemplate;
	
	public int newRcdNO() throws Exception{
		int newNO = 0;
		String Query = "select max(rcdNO) from ysboard";
		List<Integer> list = jdbcTemplate.query(Query, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int newNO = 0;
				if(rs.next()) {
					newNO = rs.getInt(1)+1;
				}
				return new Integer(newNO);
			}			
		});
		newNO = list.get(0);
		return newNO;
	}
	
	
	public void insertRecord(BoardVO boardVO) throws Exception {
		
		String Query="";
		
		Query = "insert into ysboard ";
		Query += "(rcdNO, rcdGrpNO, userName, userMail, rcdSubject, rcdContent, ";
		Query += "rcdPass, rcdRefer, rcdIndent, rcdOrder) ";
		Query += "values (?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(Query,
				boardVO.getRcdNO(),
				boardVO.getRcdGrpNO(),
				boardVO.getUserName(),
				boardVO.getUserMail(),
				boardVO.getRcdSubject(),
				boardVO.getRcdContent(),
				boardVO.getRcdPass(),
				boardVO.getRcdRefer(),
				boardVO.getRcdIndent(),
				boardVO.getRcdOrder()
				);		
	}
	
	public void deleteRecord (int rNo) throws Exception {
		
		String Query="delete from ysboard where rcdNO=?";
		
		jdbcTemplate.update(Query,rNo);
	}
	
	public void modifyRecord(int rNo, BoardVO boardVO) throws Exception {
		String Query="";
		
		Query = "update ysboard set userMail=?, rcdSubject=?, rcdContent=? ";
		Query += "where rcdNO=?";
		
		jdbcTemplate.update(Query,
				boardVO.getUserMail(),
				boardVO.getRcdSubject(),
				boardVO.getRcdContent(),
				rNo
				);
	}
	
	public List<BoardVO> selectAllRecords(String col, String key) throws Exception {
			
			String Query="";
			String Query_Sub1 = "";
			String Query_Sub2 = "";
			
			Query="select rcdNO, rcdSubject, userName, rcdDate, rcdRefer, rcdIndent from ysboard";
							
			if( (col != null) && (col.equals("rcdSubject")) ) {
				Query_Sub1 = " where rcdSubject like '%"+key+"%'";				
			} else if( (col != null) && col.equals("rcdContent") ) {
				Query_Sub1 = " where rcdContent like '%"+key+"%'";
			}
	
			Query_Sub2 = " order by rcdGrpNO desc, rcdOrder asc";
			// Query_Sub2 += " limit "+ pageIndex +", "+pageRecords;		
					
			Query = Query + Query_Sub1 + Query_Sub2;
			
			List<BoardVO> boards = jdbcTemplate.query(Query, new RowMapper<BoardVO>() {
				@Override
				public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardVO boardVO = new BoardVO();
					
					boardVO.setRcdNO(rs.getInt("rcdNO"));
					boardVO.setRcdSubject(rs.getString("rcdSubject"));
					boardVO.setUserName(rs.getString("userName"));
					boardVO.setRcdDate((java.sql.Date)rs.getDate("rcdDate"));
					boardVO.setRcdRefer(rs.getInt("rcdRefer"));
					boardVO.setRcdIndent(rs.getInt("rcdIndent"));
					
					return boardVO;
				}
			});
			return boards;
		}
	
	public int totalRecord(String col, String key) throws Exception {
		
		int totalRecord = 0;
		String Query = "";
		String Query_Sub="";
		
		Query = "select count(rcdNO) from ysboard";
		
		if( (col != null) && (col.equals("rcdSubject")) ) {
			Query_Sub = " where rcdSubject like '%"+key+"%'";				
		} else if( (col != null) && col.equals("rcdContent") ) {
			Query_Sub = " where rcdContent like '%"+key+"%'";
		}
		
		Query = Query + Query_Sub;
		
		List<Integer> list = jdbcTemplate.query(Query, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int totalRecord = 0;
				
				if( rs.next() ) totalRecord = rs.getInt(1);
				
				return new Integer(totalRecord);
			}
		});
		totalRecord = list.get(0);
		return totalRecord;
		}
	
	public void incrementRcdRefer(int rNo) throws Exception {
		String Query = "update ysboard set rcdRefer=rcdRefer+1 where rcdNO=?";
		jdbcTemplate.update(Query, rNo);
	}
	
	public BoardVO selectRecord(int rNo) throws Exception {
		BoardVO record = new BoardVO();
		
		String Query = "";
		Query = "select rcdNO, userName, userMail, rcdSubject, rcdContent, rcdDate, rcdRefer ";
		Query += "from ysboard where rcdNO=?";
		
		List<BoardVO> boards = jdbcTemplate.query(Query,
				new RowMapper<BoardVO>() {		
					
					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						BoardVO record = new BoardVO();
						record.setRcdNO(rs.getInt("rcdNO"));
						record.setUserName(rs.getString("userName"));
						record.setUserMail(rs.getString("userMail"));
						record.setRcdSubject(rs.getString("rcdSubject"));
						record.setRcdContent(rs.getString("rcdContent"));
						record.setRcdDate((java.sql.Date)rs.getDate("rcdDate"));
						record.setRcdRefer(rs.getInt("rcdRefer"));
						return record;
						
					}
				}, rNo);
		record = boards.get(0);
		return record;
	}
	
	public BoardVO selectParentRecord(int rNo) throws Exception {
		BoardVO parent = new BoardVO();
		
		String Query = "select rcdSubject, rcdContent from ysboard where rcdNO=?";
		
		List<BoardVO> boards = jdbcTemplate.query(Query,
				new RowMapper<BoardVO>() {		
					
					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						BoardVO parent = new BoardVO();
						parent.setRcdSubject(rs.getString("rcdSubject"));
						parent.setRcdContent(rs.getString("rcdContent"));
						return parent;
						
					}
				}, rNo);
		parent = boards.get(0);
		return parent;
	}
	
	public BoardVO getParentField(int rNo) throws Exception {
		BoardVO replyField = new BoardVO();
		
		String Query = "select rcdSubject, rcdContent from ysboard where rcdNO=?";
		
		List<BoardVO> boards = jdbcTemplate.query(Query,
				new RowMapper<BoardVO>() {		
					
					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						BoardVO replyField = new BoardVO();
						replyField.setRcdGrpNO(rs.getInt("rcdGrpNO"));
						replyField.setRcdIndent(rs.getInt("rcdIndent"));
						replyField.setRcdOrder(rs.getInt("rcdOrder"));
						return replyField;
						
					}
				});
		replyField = boards.get(0);
		return replyField;
	}
	
	public void incrRcdOrder(int rGrpNo, int rOrder) throws Exception {
		String Query = "update ysboard set rcdOrder=rcdOrder+1 where ";
		Query += "rcdGrpNO=? and rcdOrder>?";
		
		jdbcTemplate.update(Query,rGrpNo,rOrder);
	}
	
	public boolean checkPassword(int rNo, String password) throws Exception {
		String realPassword = "";
		
		String Query = "select rcdPass from ysboard where rcdNO=?";
		List<String> list = jdbcTemplate.query(Query, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String realPassword = "";
				if( rs.next() ) {
					realPassword = rs.getString("rcdPass");
				}				
				
				return realPassword;
			}
			
		}, rNo);
		
		realPassword = list.get(0);
		
		if( !password.equals(realPassword) ) {
			return false;			
		} else {
			return true;
		}
		
	}
}
