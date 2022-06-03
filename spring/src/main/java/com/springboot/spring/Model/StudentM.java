package com.springboot.spring.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class StudentM extends Base{
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Version
	private Integer version;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)

    @JoinTable(
			joinColumns= {@JoinColumn(name="studentid",referencedColumnName="id")
    },
     inverseJoinColumns= {
    		 @JoinColumn(name="Courseid",referencedColumnName="id")
     }
			)
	private List<courseM> courses;
	

}
