package com.mvcmem.control;

import com.mvcmem.action.Action;
import com.mvcmem.action.DeleteFormAction;
import com.mvcmem.action.DeleteProcAction;
import com.mvcmem.action.IdCheckAction;
import com.mvcmem.action.IndexAction;
import com.mvcmem.action.RegFormAction;
import com.mvcmem.action.RegProcAction;
import com.mvcmem.action.ZipCheckAction;
import com.mvcmem.action.LoginFormAction;
import com.mvcmem.action.LoginProcAction;
import com.mvcmem.action.LogoutProcAction;
import com.mvcmem.action.ModifyFormAction;
import com.mvcmem.action.ModifyProcAction;

/*
 * 싱글톤 패턴애플리케이션이 시작될 때 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 
 * 그 메모리에 인스턴스를 만들어 사용하는 디자인패턴.생성자가 여러 차례 호출되더라도 실제로 생성되는 
 * 객체는 하나고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다. 
 * (자바에선 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아쓰기도 함)
 * 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음
 * 또한 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이
 * 데이터를 공유하기 쉽다.DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 
 * 상황에서 많이 사용
 */

//ActionFactory : 사용자의 요청을 처리할 비즈니스 로직이 구현된 XXXAction 객체의 생성을 담당함 
public class ActionFactory {
	
	//싱글톤으로 만들어라
		private static ActionFactory factory;
		
		private ActionFactory() {
			
		}
		
		public static synchronized  ActionFactory getInstance()  {
			if(factory == null) {
				factory = new ActionFactory();
			}
			return factory;
		}
		
			//매개변수로 명령이 들어오면 
		public Action getAction(String cmd) { //파라미터값 날릴떄 ServletProject/mvc/test.do?cmd = index
			Action action = null;
			
			//여기가 중요함
			
			switch(cmd) {
			
			case"index":
				action = new IndexAction();
				break;
		
			case"login":
				action = new LoginFormAction();
				break;
			
			case"loginProc":
				action = new LoginProcAction();
				break;
				
			case"logout":
				action = new LogoutProcAction();
				break;	
				
			case"regForm":
				action = new RegFormAction();
				break;
				
			case"regProc":
				action = new RegProcAction();
				break;
				
			case"idCheck":
				action = new IdCheckAction();
				break;
				
			case"zipCheck":
				action = new ZipCheckAction();
				break;
				
			case"modifyForm":
				action = new ModifyFormAction();
				break;
				
			case"modifyProc":
				action = new ModifyProcAction();
				break;
				
			case"deleteForm":
				action = new DeleteFormAction();
				break;
				
			case"deleteProc":
				action = new DeleteProcAction();
				break;
				
		
		
		
				
				
				
				
				
				
			default :
				action = new IndexAction();
				break;
			}
			
			return action;
		}
	
}
