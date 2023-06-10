CREATE OR REPLACE FUNCTION encriptar_md5()
  RETURNS trigger AS
$BODY$
BEGIN
  NEW."password" := md5(NEW."password");
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

create or replace TRIGGER trigger_encriptar_md5
  BEFORE INSERT ON comercios.usuarios
  FOR EACH ROW
  EXECUTE FUNCTION encriptar_md5();
