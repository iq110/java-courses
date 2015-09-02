/**
	Eeann ?aaeecoao eaeueoeyoi?.
*/
public class Calculator {
	/**
		?acoeuoao au?eneaiey.
	*/
	private int result;
	
	/**
		Noiie?oai a?aoiaiou.
		@param params A?aoiaiou noiie?iaaiey.
	*/
	public void add(int ... params) {
		for (Integer param : params) {
			this.result += param;
		}	
	}
	
	public void minus(int ... params){
		this.result = params[0];
		for(int i = 1; i < params.length; i++){
			this.result-=params[i];
		}
	}

    public void multiply(int ... params) {
        this.result = params[0];
        for(int i = 1; i < params.length; i++){
            this.result*=params[i];
        }
    }
	
		public void div(int ... params){
		this.result = params[0];
		for(int i = 1; i < params.length; i++){
			this.result/=params[i];
		}
	}
	
	public void pow(int ... params){
		this.result = params[0];
		for(int i = 1; i < params.length; i++){
			this.result= (int)Math.pow(this.result, params[i]);
		}
	}


	/**
		Iieo?eou ?acoeuoao.
		@return ?acoeuoao au?eneaiey.
	*/
	public int getResult() {
		return this.result;
	}

	/**
		I?enoeou ?acoeuoao au?eneaiey.
	*/
	public void cleanResult() {
		this.result = 0;
	}
}