package banking;

import java.util.ArrayList;
import java.util.List;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount  extends Account {
	private List<Person> authorizedUsers =new ArrayList<>();

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		super(company,accountNumber,pin,startingDeposit);


	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		Person AuthPerson = authorizedUsers.stream().filter(p -> p.getFirstName().equals(person.getFirstName()) &&
				p.getLastName().equals(person.getLastName())).findFirst().orElse(null);
		return AuthPerson != null;
	}
}
