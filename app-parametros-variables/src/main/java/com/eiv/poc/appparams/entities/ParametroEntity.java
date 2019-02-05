package com.eiv.poc.appparams.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eiv.poc.appparams.converters.ParametroConverter;
import com.eiv.poc.appparams.enums.ParametroEnumImpl;

@Entity @Table(name="parametros")
public class ParametroEntity {

	@EmbeddedId
	private ParametroPKEntity pk = null;
	
	@OneToOne @JoinColumn(name="entidad_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
	private EntidadEntity entidad = null;
	
	@Column(name="parametro_id", nullable=false, insertable=false, updatable=false)
	@Convert(converter = ParametroConverter.class)
	private ParametroEnumImpl parametro = null;
	
	@Column(name="valor", nullable=true, length=500)
	private String valor = null;
	
	public ParametroEntity() {
		this.pk = new ParametroPKEntity();
	}

	public ParametroEntity(EntidadEntity entidad, ParametroEnumImpl parametro) {
		super();
		this.entidad = entidad;
		this.parametro = parametro;
		this.pk = new ParametroPKEntity(entidad.getId(), parametro.getDbValue());
	}

	public EntidadEntity getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEntity entidad) {
		this.entidad = entidad;
		this.pk.setEntidadId(entidad.getId());
	}

	public ParametroEnumImpl getParametro() {
		return parametro;
	}

	public void setParametro(ParametroEnumImpl parametro) {
		this.parametro = parametro;
		this.pk.setParametroId(parametro.getDbValue());
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParametroEntity other = (ParametroEntity) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParametroEntity [pk=" + pk + "]";
	}
	
}
