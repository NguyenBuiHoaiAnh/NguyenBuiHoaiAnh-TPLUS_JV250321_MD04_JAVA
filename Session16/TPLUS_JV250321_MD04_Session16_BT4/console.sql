create database ss16_bt4;
use ss16_bt4;

create table accounts (
    id int primary key auto_increment,
    balance decimal(10,2)
);

DELIMITER &&
create procedure transfer_funds(
    in sender_id int,
    in receive_id int,
    in amount decimal(10,2)
)
begin
    declare sender_balance decimal(10,2);
    -- Kiểm tra tài khoản người gửi
    if not exists(select 1 from accounts where id = sender_id) then
        signal sqlstate '45000' set message_text = 'Không tìm thấy người gửi !';
    end if;

    -- Kiểm tra tài khoản người nhận
    if not exists(select 1 from accounts where id = receive_id) then
        signal sqlstate '45000' set message_text = 'Không tìm thấy người nhận !';
    end if;

    -- Kiểm tra số dư
    select balance into sender_balance from accounts
    where id = sender_id;

    if sender_balance < amount then
        signal sqlstate '45000' set message_text = 'Người gửi không đủ tiền';
    end if;

    -- Trừ tiền người gửi
    update accounts
    set balance = balance - amount where id = sender_id;

    -- Cộng tiền người nhận
    update accounts
    set balance = balance + amount where id = receive_id;

end;
DELIMITER &&