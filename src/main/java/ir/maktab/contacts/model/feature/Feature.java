package ir.maktab.contacts.model.feature;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ir.maktab.contacts.model.rule.Rule;

@Entity
@Table(name = "Feachures")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feachure_id")
	private long id;

	@Column(name = "feachureTitle")
	private String feachureTitle;

	@Column(name = "feachureDescribe")
	private String feachureDescribe;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "feachures", cascade = CascadeType.ALL)
	private Set<Rule> rules = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeachureTitle() {
		return feachureTitle;
	}

	public void setFeachureTitle(String feachureTitle) {
		this.feachureTitle = feachureTitle;
	}

	public String getFeachureDescribe() {
		return feachureDescribe;
	}

	public void setFeachureDescribe(String feachureDescribe) {
		this.feachureDescribe = feachureDescribe;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

}
