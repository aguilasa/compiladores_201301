package br.com.furb.comp.gals.actions;

public class ActionFactory {
	public IAction getAction(int action) {
		switch (action) {
		case 1:
			return new Action_1();
		case 2:
			return new Action_2();
		case 3:
			return new Action_3();
		case 4:
			return new Action_4();
		case 5:
			return new Action_5();
		case 6:
			return new Action_6();
		case 7:
			return new Action_7();
		case 8:
			return new Action_8();
		case 9:
			return new Action_9();
		case 10:
			return new Action_10();
		case 11:
			return new Action_11();
		case 12:
			return new Action_12();
		case 13:
			return new Action_13();
		case 14:
			return new Action_14();
		case 15:
			return new Action_15();
		case 16:
			return new Action_16();
		case 17:
			return new Action_17();
		case 18:
			return new Action_18();
		case 19:
			return new Action_19();
		case 20:
			return new Action_20();
		case 21:
			return new Action_21();
		case 22:
			return new Action_22();
		case 23:
			return new Action_23();
		case 24:
			return new Action_24();
		case 25:
			return new Action_25();
		case 26:
			return new Action_26();
		case 27:
			return new Action_27();
		case 28:
			return new Action_28();
		case 29:
			return new Action_29();
		case 30:
			return new Action_30();
		case 31:
			return new Action_31();
		case 32:
			return new Action_32();
		case 33:
			return new Action_33();
		case 34:
			return new Action_34();
		case 35:
			return new Action_35();
		case 36:
			return new Action_36();
		case 37:
			return new Action_37();
		case 38:
			return new Action_38();
		default:
			return null;
		}
	}
}
