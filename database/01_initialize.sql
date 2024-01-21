DO $$
DECLARE
    systemUser uuid := gen_random_uuid();
    startTime timestamp := NOW();

Begin

INSERT INTO ACCOUNT(id,created_date,created_by,last_modified_date,last_modified_by,name,email,password,role)
    VALUES (systemUser,startTime,systemUser,startTime,systemUser,'Admin','admin@notafakeemail.com',
            '$2a$10$tOU3k/PeeTYxkOV9gWmFke/7rI3LMB5FWa2solt.rEem98hLzQdkq','ADMIN');

INSERT INTO PRODUCT(id,created_date,created_by,last_modified_date,last_modified_by,product_type,description,calories)
VALUES (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'BEVERAGE','bottle of water',0),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'BEVERAGE','can of Coca-Cola ',138),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'BEVERAGE','cup of Orange juice',111),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'BEVERAGE','can of Sprite',146),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'MAIN_COURSE','cozido à portuguesa',1405),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'MAIN_COURSE','Cod fish with cream',621),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'MAIN_COURSE','Potato Salad',358),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'MAIN_COURSE','Tuna Salad',383),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'MAIN_COURSE','Cheeseburger with Fries',1009);
End
$$;