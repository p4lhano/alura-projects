package dev.palhano.mudi.model.types;

public enum PedidoStatusEnum {
	AGUARDANDO {
		@Override
		public String classAlertCSS() {
			return "alert-warning";
		}
	},APROVADO {
		@Override
		public String classAlertCSS() {
			return "alert-success";
		}
	},ENTREGUE {
		@Override
		public String classAlertCSS() {
			return "alert-info";
		}
	};
	
	/**
	 * Ira retorna a classe que o objete irá ser identificado no thymeleaf
	 * */
	public abstract String classAlertCSS() ;
}
