create table people (
    p_id serial primary key, -- p_id is short for people id. We made is a primary key
    name VARCHAR(50) not null, -- Name of the customer
    people_id int references people(p_id) on delete set null,
    delinquent bool default true not null, -- this for people that are not paying on time
    rank_id VARCHAR(20) not null, -- this creates the rank for the people
    check (rank_id in ('Customer', 'Employee', 'Admin')) -- the people can either be Customer, Employee, or Admin
);


alter table people DROP COLUMN rank_id;

ALTER TABLE people
ADD COLUMN password varchar(50);

ALTER TABLE people
ADD COLUMN phone varchar(50);

insert into people values 
(default, 'Josh Newman', false, 'Customer'),
(default, 'Morgan Freeman', true, 'Customer'),
(default, 'Jeff Bezos', false, 'Employee'),
(default, 'Elon Musk', false, 'Admin');

insert into people values 
(default, 'Naruto Uzumaki', false, 'Customer'),
(default, 'Itachi Uchiha', true, 'Customer'),
(default, 'Ichigo Kurosaki', false, 'Employee'),
(default, 'Luffy D Monkey', false, 'Admin');

insert into people values 
(default, 'Sakura Uchiha', false, 'Customer'),
(default, 'Hinata Uzumaki', true, 'Customer'),
(default, 'Boa Hancock', false, 'Employee'),
(default, 'Inoue Orihime', false, 'Admin');

insert into people values 
(default, 'Steve Jobs', false, 'Customer'),
(default, 'Eiichiro Oda', true, 'Customer'),
(default, 'Masashi Kishimoto', false, 'Employee'),
(default, 'Tite Kubo', false, 'Employee'),
(default, 'Yoshihiro Togashi', false, 'Admin');




select * from people;

delete from people where p_id = 4;

create table accounts (
    a_id serial primary key, -- a_id is short for account id. We made is a primary key
    people_id int references people(p_id) on delete set null, -- Name of the customer
    balance numeric(12,2), --  this is creates a balance
    date_created bigint default 0, -- this when the account is createdpeople that are not paying on time
    type VARCHAR(500) not null, -- this the type of the account checkings or saving
    interest_rate VARCHAR(500) -- the is the interest rate
);

alter table accounts DROP COLUMN interest_rate;

ALTER TABLE accounts 
ADD COLUMN interest_rate numeric(12,5) default 0;

alter table accounts DROP COLUMN type;

ALTER TABLE accounts 
ADD COLUMN account_type varchar(500);


drop table account

insert into accounts values
(default, 5, 1000, 'Checking', '1', .0005);
(default, 2, 100213, 1, 'Loan', '5.0'),
(default, 3, 2384732, 1, 'Savings', '0.7'),
(default, 4, 12000, 1, 'Kids College Checking', '0.004');

insert into accounts values
(default, 1, 20000, 2, 'Savings', '4.0');

select * from people where name = 'Bob Sam'
select * from accounts where people_id = 1 


select * from people;
select * from accounts;

create table ranks (
    r_id varchar(50) primary key, -- rank_id is short for rank id. We made is a primary key
    permission VARCHAR(100) not null -- this the type of the that give certain permissions to the users
);

insert into ranks values
('Customer', 'Creates/Closes Accounts'),
('Employee', 'Send Requests'),
('Admin', 'Access/Request Everything');

drop table ranks;

select * from ranks


create table bank_statements (
    bs_id serial primary key, 										-- bs_id is short for bankstatement id. We made is a primary key
    people_id int references people (name) on delete set null, 		-- this tables references people table through people_id
    account_id int references accounts (a_id) on delete set null, 	-- the is the account id
    date_created date not null default current_date, 									-- this is creates the date
    action_type VARCHAR(15), 										-- this creates the action type
    check(action_type in('WITHDRAW', 'DEPOSIT')), -- these are the base actions that can be performed
    amount NUMERIC(12,2), 											-- this the type of the account checkings or saving
    where_to VARCHAR(20), 											-- this where the money is coming from
	from_where VARCHAR(20)											-- this is where the money comes from)
);


alter table bank_statements DROP COLUMN date_created;

ALTER TABLE bank_statements
ADD COLUMN date_created bigint default 0;

select current_date

drop table bank_statements

insert into bank_statements values 
(default, 5, 3, '2022-11-24', 'WITHDRAW', -100.00, '1223', 'my account'),
(default, 5, 3, '2022-11-24', 'DEPOSIT', 100.00, '1223', 'my account');

select * from bank_statements;

delete from bank_statements where bs_id = 11;

----------------------------------------------
----------------------------------------------

truncate table people, accounts, bank_statements, ranks;

select * from people;
select * from accounts;
select * from bank_statements;
select * from ranks;

insert into ranks values
('Customer', 'Creates/Closes Accounts'),
('Employee', 'Send Requests'),
('Admin', 'Access/Request Everything'); 

insert into people values 
(default, 'Naruto Uzumaki', false, 'Customer', '1234', 'n_uzumaki', '210-212-1221'),
(default, 'Itachi Uchiha', true, 'Customer', '132423', 'i_uchiha', '122-123-1233'),
(default, 'Ichigo Kurosaki', false, 'Employee', 'sword23123', 'i_kurosaki213', '111-222-2333'),
(default, 'Luffy D Monkey', false, 'Admin', 'luffyluffymonkey', 'monkey_luffy', '123-311-1111');

insert into accounts values
(default, 40, 100, 220824, null, .0005, 'Checking'),
(default, 41, 100213, 220926, null, 5.0, 'Loan'),
(default, 42, 2384732, 220804, null, 0.725, 'Savings'),
(default, 43, 12000, 221014, null, 0.004, 'Kids College Checking'),
(default, 40, 100000, 220825, null, 7.23, 'Savings');


insert into bank_statements values 
(default, 16, 'WITHDRAW', 100.00, 'My Checking Account', 'My Savings Account', 220925),
(default, 14, 'DEPOSIT', 1000.00, 'Big Bank', 'My Savings Account', 221025);






