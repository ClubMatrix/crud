-- Inserting permissions
INSERT INTO permission (slug, name, description) VALUES
('view_members', 'View Members', 'Permission to view club members and their details'),
('edit_members', 'Edit Members', 'Permission to edit club member details'),
('register_activity', 'Register Activity', 'Permission to register a new activity'),
('view_activities', 'View Activities', 'Permission to view all activities'),
('manage_employees', 'Manage Employees', 'Permission to register and edit employee details'),
('set_permissions', 'Set Permissions', 'Permission to set permissions for employees'),
('view_employee_summary', 'View Employee Summary', 'Permission to view employee summaries');

-- Inserting roles
INSERT INTO role (name, slug, description) VALUES
('employee', 'employee', 'Basic club employee'),
('manager', 'manager', 'Club manager with higher level permissions');

-- Setting up role-permission relationships

-- Permissions for employee role
INSERT INTO role_permission (role_id, permission_id) VALUES
((SELECT id FROM role WHERE slug = 'employee'), (SELECT id FROM permission WHERE slug = 'view_members')),
((SELECT id FROM role WHERE slug = 'employee'), (SELECT id FROM permission WHERE slug = 'edit_members')),
((SELECT id FROM role WHERE slug = 'employee'), (SELECT id FROM permission WHERE slug = 'register_activity')),
((SELECT id FROM role WHERE slug = 'employee'), (SELECT id FROM permission WHERE slug = 'view_activities'));

-- Permissions for manager role
INSERT INTO role_permission (role_id, permission_id) VALUES
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'view_members')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'edit_members')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'register_activity')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'view_activities')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'manage_employees')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'set_permissions')),
((SELECT id FROM role WHERE slug = 'manager'), (SELECT id FROM permission WHERE slug = 'view_employee_summary'));
