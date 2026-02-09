package board.data;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	public void insertBoard(BoardDto dto);
	public List<BoardDto> selectBoard(int start,int perpage);
	public BoardDto selectContent(int num);
	public void updateReadcount(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardDto dto);
	public int getCheckPass(int num,int pass);
}
