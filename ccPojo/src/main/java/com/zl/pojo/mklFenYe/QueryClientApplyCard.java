package com.zl.pojo.mklFenYe;

import org.springframework.stereotype.Component;

@Component
public class QueryClientApplyCard {
	
	/**申请身份证号*/
	private String applyIdcard;
	
	/**核实状态*/
	private String applyCheckState;
	
	/**申请状态*/
	private String applyState;

	public String getApplyIdcard() {
		return applyIdcard;
	}

	public String getApplyCheckState() {
		return applyCheckState;
	}

	public String getApplyState() {
		return applyState;
	}

	public void setApplyIdcard(String applyIdcard) {
		this.applyIdcard = applyIdcard;
	}

	public void setApplyCheckState(String applyCheckState) {
		this.applyCheckState = applyCheckState;
	}

	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}

	@Override
	public String toString() {
		return "QueryClientApplyCard [applyIdcard=" + applyIdcard + ", applyCheckState=" + applyCheckState
				+ ", applyState=" + applyState + "]";
	}

	
	
	

}
