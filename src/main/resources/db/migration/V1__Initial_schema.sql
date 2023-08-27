CREATE TYPE payment_details_enum AS ENUM ('Credit Card', 'Debit Card', 'Bank Transfer', 'Cash');
CREATE TYPE status_enum AS ENUM ('Active', 'Inactive', 'Suspended');

CREATE TABLE addresses (
  id SERIAL PRIMARY KEY,
  street TEXT NOT NULL,
  city VARCHAR(100) NOT NULL,
  state VARCHAR(100),
  postal_code VARCHAR(20),
  country VARCHAR(100) NOT NULL
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(82) NOT NULL,
  phone VARCHAR(15),
  address_id INT REFERENCES addresses(id) ON DELETE SET NULL
);

CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  slug VARCHAR(255) UNIQUE NOT NULL,
  description TEXT
);

CREATE TABLE permissions (
  id SERIAL PRIMARY KEY,
  slug VARCHAR(255) UNIQUE NOT NULL,
  name TEXT NOT NULL,
  description TEXT
);

CREATE TABLE user_roles (
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  role_id INT REFERENCES roles(id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, role_id)
);

CREATE TABLE user_permissions (
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  permission_id INT REFERENCES permissions(id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, permission_id)
);

CREATE TABLE role_permissions (
  role_id INT REFERENCES roles(id) ON DELETE CASCADE,
  permission_id INT REFERENCES permissions(id) ON DELETE CASCADE,
  PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE members (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  payment_details payment_details_enum,
  status status_enum NOT NULL
);

CREATE TABLE dependents (
  id SERIAL PRIMARY KEY,
  member_id INT REFERENCES members(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  relationship TEXT NOT NULL
);

CREATE TABLE activities (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  age_range VARCHAR(50),
  skill_level VARCHAR(50),
  class_schedule TEXT
);

CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  position TEXT NOT NULL,
  salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE employment_histories (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employees(id) ON DELETE CASCADE,
  company_name TEXT NOT NULL,
  position TEXT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  description TEXT
);

CREATE TABLE feedbacks (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employees(id) ON DELETE CASCADE,
  date_received TIMESTAMP NOT NULL,
  provided_by TEXT NOT NULL,
  content TEXT NOT NULL
);
