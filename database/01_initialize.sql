DO $$
DECLARE
    systemUser uuid := gen_random_uuid();
    startTime timestamp := NOW();

Begin

INSERT INTO PRODUCT(id,created_date,created_by,last_modified_date,last_modified_by,product_type,description,calories)
VALUES (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'beverage','bottle of water',0),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'beverage','can of Coca-Cola ',138),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'beverage','cup of Orange juice',111),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'beverage','can of Sprite',146),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'main_course','cozido à portuguesa',1405),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'main_course','Cod fish with cream',621),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'main_course','Potato Salad',358),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'main_course','Tuna Salad',383),
       (gen_random_uuid(),startTime,systemUser,startTime,systemUser,'main_course','Cheeseburger with Fries',1009);
End
$$;