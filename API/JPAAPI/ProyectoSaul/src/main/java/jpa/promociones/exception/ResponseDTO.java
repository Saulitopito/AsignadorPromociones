package jpa.promociones.exception;

public class ResponseDTO {
	
	private String mensaje;
	private Boolean exito;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Boolean getExito() {
		return exito;
	}
	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	
	
	
}
