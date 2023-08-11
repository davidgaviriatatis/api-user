package com.nissum.apiuser.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "phones")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Phone implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String number;
	
	@NonNull
	private String citycode;
	
	@NonNull
	private String countrycode;
	
	private static final long serialVersionUID = 1L;

}
