package board.answer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnswerController {

	@Autowired
	AnswerDao dao;
	
	@PostMapping("/board/aInsert")
	public ModelAndView aInsert(@ModelAttribute AnswerDto dto,@RequestParam int num,@RequestParam int currentPage) {
		ModelAndView mav=new ModelAndView();
		
		dao.insertAnswer(dto);
		
		mav.setViewName("redirect:content?num="+dto.getNum()+"&currentPage="+currentPage);
		return mav;
	}
}
