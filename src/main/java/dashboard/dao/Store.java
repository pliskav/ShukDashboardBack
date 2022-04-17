package dashboard.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Entity
@Table(name = "restaurants")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
	@Id
	int id;
	@Column(name = "name")
	String store_name;

}
