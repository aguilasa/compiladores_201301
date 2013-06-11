package br.com.furb.comp.gals.actions;

public enum Actions {
	ACAO_01(Action_01.class),
	ACAO_02(Action_02.class),
	ACAO_03(Action_03.class),
	ACAO_04(Action_04.class),
	ACAO_05(Action_05.class),
	ACAO_06(Action_06.class),
	ACAO_07(Action_07.class),
	ACAO_08(Action_08.class),
	ACAO_09(Action_09.class),
	ACAO_10(Action_10.class),
	ACAO_11(Action_11.class),
	ACAO_12(Action_12.class),
	ACAO_13(Action_13.class),
	ACAO_14(Action_14.class),
	ACAO_15(Action_15.class),
	ACAO_16(Action_16.class),
	ACAO_17(Action_17.class),
	ACAO_18(Action_18.class),
	ACAO_19(Action_19.class),
	ACAO_20(Action_20.class),
	ACAO_21(Action_21.class),
	ACAO_22(Action_22.class),
	ACAO_23(Action_23.class),
	ACAO_24(Action_24.class),
	ACAO_25(Action_25.class),
	ACAO_26(Action_26.class),
	ACAO_27(Action_27.class),
	ACAO_28(Action_28.class),
	ACAO_29(Action_29.class),
	ACAO_30(Action_30.class),
	ACAO_31(Action_31.class),
	ACAO_32(Action_32.class),
	ACAO_33(Action_33.class),
	ACAO_34(Action_34.class),
	ACAO_35(Action_35.class),
	ACAO_36(Action_36.class),
	ACAO_37(Action_37.class),
	ACAO_38(Action_38.class);

	private Class<? extends IAction> action;

	private Actions(Class<? extends IAction> action) {
		this.action = action;
	}

	public IAction getAction() {
		try {
			return action.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(String.format("Não foi possível instanciar a action %s", action.getCanonicalName()));
		}
	}
}
