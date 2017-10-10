package kr.or.dgit.jdbc_setting;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_setting.servise.DbService;
import kr.or.dgit.jdbc_setting.servise.InitService;

@SuppressWarnings("serial")
public class BtnAction extends AbstractAction {
	
	public BtnAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DbService servise = null;
		// 초기화, 백업, 복원
		switch(e.getActionCommand()){
		case "초기화":
			servise = InitService.getInstance();	
			break;
		case "백업" :
			servise = ExportService.getInstance();
			break;
		case "복원" :
			servise = ImportServise.getInstance();
			break;
		}
		servise.service();
		JOptionPane.showMessageDialog(null, e.getActionCommand() + "가(이) 완료되었습니다.");
	}

}
