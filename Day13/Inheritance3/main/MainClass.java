package main;

import cls.ChildOneClass;
import cls.ChildTwoClass;
import cls.ParentClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		ParentClass pc = new ParentClass();
		pc.overRidemethod();
		
		ChildOneClass coc = new ChildOneClass();
		coc.overRidemethod();
		
		ChildTwoClass ctc = new ChildTwoClass();
		ctc.overRidemethod();
		
		
		ParentClass pc1 = new ChildOneClass();
		pc1.overRidemethod();
		

		ParentClass pc2 = new ChildTwoClass();
		pc2.overRidemethod();
		*/
		
		ChildOneClass arrCOC[] = new ChildOneClass[10];
		ChildTwoClass arrCTC[] = new ChildTwoClass[10];
		/*
		// 고급? 보통? 따로 관리
		arrCOC[0] = new ChildOneClass();
		arrCTC[0] = new ChildTwoClass();
		arrCOC[1] = new ChildOneClass();
		arrCTC[2] = new ChildTwoClass();
		arrCTC[1] = new ChildTwoClass();
		arrCTC[3] = new ChildTwoClass();
		arrCTC[4] = new ChildTwoClass();
		arrCOC[2] = new ChildOneClass();
		arrCTC[5] = new ChildTwoClass();
		arrCTC[6] = new ChildTwoClass();
		
		for (int i = 0; i < arrCOC.length; i++) {
			if(arrCOC[i] != null) {
				arrCOC[i].overRidemethod();
			}
		}
		for (int i = 0; i < arrCOC.length; i++) {
			if(arrCTC[i] != null) {
				arrCTC[i].overRidemethod();
			}
		}
		*/
		
		ParentClass arrPar[] = new ParentClass[10];
		// 관리하기 용이
		arrPar[0] = new ChildOneClass();
		arrPar[1] = new ChildTwoClass();
		arrPar[2] = new ChildOneClass();
		arrPar[3] = new ChildTwoClass();
		arrPar[4] = new ChildTwoClass();
		arrPar[5] = new ChildTwoClass();
		arrPar[7] = new ChildTwoClass();
		arrPar[6] = new ChildOneClass();
		arrPar[8] = new ChildTwoClass();
		arrPar[9] = new ChildTwoClass();
		// 순서대로 출력
		for (int i = 0; i < arrPar.length; i++) {
			arrPar[i].overRidemethod();
			
			if(arrPar[i] instanceof ChildOneClass) {	// 이게 맞는지 확인
				ChildOneClass cOne =(ChildOneClass)arrPar[i];
				cOne.OneMethod();
			}
			else if(arrPar[i] instanceof ChildTwoClass) {
				ChildTwoClass cTwo =(ChildTwoClass)arrPar[i];
				cTwo.Twofunc();
			}
		}
		 
	//	ChildOneClass cOne =(ChildOneClass)arrPar[0];
	//	cOne.OneMethod();
		
		/*
		// instanceof
		if(arrPar[1] instanceof ChildOneClass) {	// 이게 맞는지 확인
			ChildOneClass cOne =(ChildOneClass)arrPar[1];
			cOne.OneMethod();
		}
		else if(arrPar[1] instanceof ChildTwoClass) {
			ChildTwoClass cTwo =(ChildTwoClass)arrPar[1];
			cTwo.Twofunc();
		}*/
	}
}
