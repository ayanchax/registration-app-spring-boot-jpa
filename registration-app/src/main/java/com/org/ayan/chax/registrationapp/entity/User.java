package com.org.ayan.chax.registrationapp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String firstname;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String lastname;

	@Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
	private String email;

	@Column(nullable = false)
	private Date dob;

	@Column(columnDefinition = "varchar(45) default 'ANONYMOUS'", updatable = false)
	private String created_by;

	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP", updatable = false)
	private Timestamp created_at;

	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Timestamp last_modified;

	@PrePersist
	void preInsert() {
		if (this.created_by == null)
			this.created_by = "ANONYMOUS";

		if (this.created_at == null)
			this.created_at = new Timestamp(System.currentTimeMillis());
	}

}
