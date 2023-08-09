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