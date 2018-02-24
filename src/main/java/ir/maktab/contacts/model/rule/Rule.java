package ir.maktab.contacts.model.rule;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ir.maktab.contacts.model.feature.Feature;

@Entity
@Table(name = "Rules")
public class Rule implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rule_id")
	private long id;

	@Column(name = "ruleTitle")
	private String ruleTitle;

	@Column(name = "ruleDescribe")
	private String ruleDescribe;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Rules_Feachures", joinColumns = { @JoinColumn(name = "rule_id") }, inverseJoinColumns = {
			@JoinColumn(name = "feachure_id") })
	private Set<Feature> feachures = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleTitle() {
		return ruleTitle;
	}

	public void setRuleTitle(String ruleTitle) {
		this.ruleTitle = ruleTitle;
	}

	public String getRuleDescribe() {
		return ruleDescribe;
	}

	public void setRuleDescribe(String ruleDescribe) {
		this.ruleDescribe = ruleDescribe;
	}

	public Set<Feature> getFeachures() {
		return feachures;
	}

	public void setFeachures(Set<Feature> feachures) {
		this.feachures = feachures;
	}

}
