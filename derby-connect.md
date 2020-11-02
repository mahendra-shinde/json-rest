Connect to Derby database using h2-console
Choose "Derby Server" from first drop-down
Use Connection url: jdbc:derby://localhost:1527/scdb;create=true
Username: sa
password: password@1234

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

derby-client dependency:
<dependency>
    <groupId>org.apache.derby</groupId>
    <artifactId>derbyclient</artifactId>
    <version>10.14.2.0</version>
</dependency>

Sample User data:

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

Add following bean inside Application class

	@Bean("securityDS")
	public DataSource securityDS() {
		DataSource ds = new SimpleDriverDataSource(new ClientDriver(),
				"jdbc:derby://localhost:1527/scdb","sa","password@1234");
		return ds;
	}
