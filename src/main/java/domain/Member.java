
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.PROPERTY)
public class Member extends Actor {

	//Relationships

	private Finder	finder;


	//Relationships

	@OneToOne(optional = false)
	public Finder getFinder() {
		return this.finder;
	}

	public void setFinder(final Finder finder) {
		this.finder = finder;
	}

}
