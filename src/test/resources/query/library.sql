-- US01 -1
select count(id) from users; -- actual

select count(distinct id) from users; -- expected
-- US01 -2
select * from users;

-- US02
-- UI -> 213
-- DB -> 213
SELECT COUNT(*) FROM book_borrow
WHERE is_returned=0;

-- US03
select name from book_categories;


-- US04

SELECT * from books where name='Clean Code';

SELECT b.name,b_c.name from books b
                                inner join book_categories b_c
                                           on b.book_category_id=b_c.id where b.name='Clean Code';