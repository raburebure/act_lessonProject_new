package entity;

/**
 * Usersテーブルのエンティティクラス
 *
 */
public class UsersEntity {

	private String employeeNum;
	private String password;
	private String employeeName;
	private int authority;

	/**
	 * コンストラクタ
	 */
	public UsersEntity() {
		this.employeeNum = "";
		this.password = "";
		this.employeeName = "";
		this.authority = 0;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
}