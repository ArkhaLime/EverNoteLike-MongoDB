rem mongo
rem use mongonote
rem show collections
rem db.users.drop()
rem db.notes.drop()
rem exit

mongoimport --db mongonote --collection users --file users.json
mongoimport --db mongonote --collection notes --file notes.json

pause