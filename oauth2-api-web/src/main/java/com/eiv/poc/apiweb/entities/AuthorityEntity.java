package com.eiv.poc.apiweb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity @Table(name="authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"nombre"})
	})
public class AuthorityEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Column(name="id")
	private Long id = null;
	
	@Column(name="nombre", nullable=false, length=100)
	private String authority = null;
	
	public AuthorityEntity() {}

	public AuthorityEntity(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AuthorityEntity other = (AuthorityEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthorityEntity [id=" + id + ", authority=" + authority + "]";
	}	
}
