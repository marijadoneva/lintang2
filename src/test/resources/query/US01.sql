create table users
(
    id int not null

SELECT count(id) ids
     , count(distinct id) distinct_ids
FROM users;


/*
  When Execute all columns
    Then verify the below columns are listed in result
      | id |
      | full_name |
      | email |
      | password |
      | user_group_id |
      | image |
      | extra_data |
      | status |
      | is_admin |
      | start_date |
      | end_date |
      | address |
 */
--
SELECT COLUMN_NAME
FROM information_schema.COLUMNS
WHERE TABLE_NAME = 'users';




SELECT count(address) addrs
     , count(distinct address) distinct_addrs
FROM users;

select address, max(full_name) firstperson, min(full_name) lastperson, count(distinct id)
from users
group by address
having count(*);