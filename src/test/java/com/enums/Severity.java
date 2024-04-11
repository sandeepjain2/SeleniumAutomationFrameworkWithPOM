package com.enums;

public enum Severity {

//	CRITICAL {
//		@Override
//		public String asLowerCase() {
//			// TODO Auto-generated method stub
//			return Severity.CRITICAL.toString().toLowerCase();
//		}
//	},
//	HIGH {
//		@Override
//		public String asLowerCase() {
//			// TODO Auto-generated method stub
//			return Severity.HIGH.toString().toLowerCase();
//		}
//	},
//	MEDIUM {
//		@Override
//		public String asLowerCase() {
//			// TODO Auto-generated method stub
//			return Severity.MEDIUM.toString().toLowerCase();
//		}
//	},
//	LOW {
//		@Override
//		public String asLowerCase() {
//			// TODO Auto-generated method stub
//			return Severity.LOW.asLowerCase();
//		}
//	};
//
//
//	public abstract String asLowerCase();
	
	
	
	CRITICAL(2), MEDIUM(4), HIGH(6), LOW(8);
	
	private int fixingHours;

	public int getFixingHours() {
		return fixingHours;
	}

	public void setFixingHours(int fixingHours) {
		this.fixingHours = fixingHours;
	}
	
	private Severity(int hours) {
		fixingHours = hours;
	}
	
}
