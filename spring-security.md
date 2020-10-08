# Spring security with REST

1. You need to additional JDBC driver
```xml
<dependency>
    <groupId>org.apache.derby</groupId>
    <artifactId>derbyclient</artifactId>
    <version>10.14.2.0</version>
</dependency>
```

2. Create User schema for Authentication

```sql
CREATE table users
(
  username varchar(40) not null primary key ,
  password varchar(20) not null,
  enabled int not null default 1
);

CREATE table user_roles (
  role_id int not null ,
  username varchar(40) not null,
  role varchar(20) not null,
  primary key (role_id),
  constraint fk1 foreign key (username) references users(username)
);
```

Sample User data:

```sql
INSERT into USERS (username, password)
VALUES ('mahendra', 'pass@12345');

INSERT into USERS (username, password)
VALUES ('narendra', 'pass@12345');

INSERT into USERS (username, password)
VALUES ('rajendra', 'pass@12345');

INSERT into USERS (username, password)
VALUES ('surendra', 'pass@12345');

INSERT into user_roles (username, role, role_id)
VALUES('mahendra', 'admin', 1);

INSERT into user_roles (username, role, role_id)
VALUES('mahendra', 'user', 2);

INSERT into user_roles (username, role, role_id)
VALUES('narendra', 'user', 3);

INSERT into user_roles (username, role, role_id)
VALUES('rajendra', 'admin', 4);

INSERT into user_roles (username, role, role_id)
VALUES('surendra', 'user', 5);
```

3. Modify the Web Security configuration class

```java
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/account/**").hasRole("USER")
		.antMatchers("/h2-console").permitAll().and().formLogin().disable();
		
//	    http.antMatcher("/account**").authorizeRequests().antMatchers("/h2-console").permitAll()
//        .and().formLogin().disable();
	}

    @bean
	public DataSource securityDS() {
		DataSource ds = new SimpleDriverDataSource(new ClientDriver(),
				"jdbc:derby://localhost:1527/scdb","sa","password@1234");
		return ds;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(securityDS())
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
			
	}
}
```