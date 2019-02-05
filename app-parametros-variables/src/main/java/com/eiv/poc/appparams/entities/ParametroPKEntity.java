package com.eiv.poc.appparams.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParametroPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="entidad_id") private Long entidadId = null;
	@Column(name="parametro_id") private Integer parametroId = null;
	
	public ParametroPKEntity() {
	}

	public ParametroPKEntity(Long entidadId, Integer parametroId) {
		super();
		this.entidadId = entidadId;
		this.parametroId = parametroId;
	}

	public Long getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Long entidadId) {
		this.entidadId = entidadId;
	}

	public Integer getParametroId() {
		return parametroId;
	}

	public void setParametroId(Integer parametroId) {
		this.parametroId = parametroId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entidadId == null) ? 0 : entidadId.hashCode());
		result = prime * result + ((parametroId == null) ? 0 : parametroId.hashCode());
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
		ParametroPKEntity other = (ParametroPKEntity) obj;
		if (entidadId == null) {
			if (other.entidadId != null)
				return false;
		} else if (!entidadId.equals(other.entidadId))
			return false;
		if (parametroId == null) {
			if (other.parametroId != null)
				return false;
		} else if (!parametroId.equals(other.parametroId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParametroPKEntity [entidadId=" + entidadId + ", parametroId=" + parametroId + "]";
	}
	
}
