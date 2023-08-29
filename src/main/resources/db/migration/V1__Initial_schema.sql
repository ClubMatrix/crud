CREATE TYPE payment_details_enum AS ENUM ('Credit Card', 'Debit Card', 'Bank Transfer', 'Cash');
CREATE TYPE status_enum AS ENUM ('Active', 'Inactive', 'Suspended');

CREATE TABLE address (
  id SERIAL PRIMARY KEY,
  street TEXT NOT NULL,
  city VARCHAR(100) NOT NULL,
  state VARCHAR(100),
  postal_code VARCHAR(20),
  country VARCHAR(100) NOT NULL
);

CREATE TABLE login (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(82) NOT NULL,
  phone VARCHAR(15),
  address_id INT REFERENCES address(id) ON DELETE SET NULL
);

CREATE TABLE role (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  slug VARCHAR(255) UNIQUE NOT NULL,
  description TEXT
);

CREATE TABLE permission (
  id SERIAL PRIMARY KEY,
  slug VARCHAR(255) UNIQUE NOT NULL,
  name TEXT NOT NULL,
  description TEXT
);

CREATE TABLE login_role (
  login_id INT REFERENCES login(id) ON DELETE CASCADE,
  role_id INT REFERENCES role(id) ON DELETE CASCADE,
  PRIMARY KEY (login_id, role_id)
);

CREATE TABLE login_permission (
  login_id INT REFERENCES login(id) ON DELETE CASCADE,
  permission_id INT REFERENCES permission(id) ON DELETE CASCADE,
  PRIMARY KEY (login_id, permission_id)
);

CREATE TABLE role_permission (
  role_id INT REFERENCES role(id) ON DELETE CASCADE,
  permission_id INT REFERENCES permission(id) ON DELETE CASCADE,
  PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE member (
  id SERIAL PRIMARY KEY,
  login_id INT REFERENCES login(id) ON DELETE CASCADE,
  payment_details payment_details_enum,
  status status_enum NOT NULL
);

CREATE TABLE dependent (
  id SERIAL PRIMARY KEY,
  member_id INT REFERENCES member(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  relationship TEXT NOT NULL
);

CREATE TABLE activity (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  age_range VARCHAR(50),
  skill_level VARCHAR(50),
  class_schedule TEXT
);

CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  login_id INT REFERENCES login(id) ON DELETE CASCADE,
  position TEXT NOT NULL,
  salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE employment_history (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employee(id) ON DELETE CASCADE,
  company_name TEXT NOT NULL,
  position TEXT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  description TEXT
);

CREATE TABLE feedback (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employee(id) ON DELETE CASCADE,
  date_received TIMESTAMP NOT NULL,
  provided_by TEXT NOT NULL,
  content TEXT NOT NULL
);
