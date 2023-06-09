/**
 * 
 */
package com.tourism.management.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BranchDetails entity
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("Branch")
public class Branch {

	@Id
	private int branchId;
	private String branchName;
	private String website;	
	private int contactNo;	
	private String email;
	private List<Place> places;
	private Date auditTimeStamp;
}
