/**
 * 
 */
package com.tourism.management.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BranchDetails Model
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDetail {

	private String branchId;
	private String branchName;
	private String website;	
	private int contactNo;	
	private String email;
	private List<Place> places;
}
