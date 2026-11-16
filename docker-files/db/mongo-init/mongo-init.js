// Mongo ejecuta este archivo contra la base MONGO_INITDB_DATABASE (dbPartner)
const dbName = process.env.MONGO_INITDB_DATABASE || "dbPartner";
const appDb = db.getSiblingDB(dbName);

// Usuario de aplicacion (el que usara mclientes, sin ser admin)
appDb.createUser({
  user: process.env.MONGO_USER,
  pwd: process.env.MONGO_PASSWORD,
  roles: [{ role: "readWrite", db: dbName }]
});

// Coleccion de clientes
appDb.createCollection("clientes");
appDb.clientes.createIndex({ correo: 1 }, { unique: true });

// Datos iniciales: todo en MAYUSCULA y sin tildes
appDb.clientes.insertMany([
  { nombre: "JOSE",     paterno: "QUISPE",    correo: "JOSE.QUISPE@CORREO.COM",    direccion: "AV. LOS HEROES 123, SAN JUAN DE MIRAFLORES", telefono: "987654321" },
  { nombre: "MARIA",    paterno: "HUAMAN",    correo: "MARIA.HUAMAN@CORREO.COM",   direccion: "JR. HUANCAVELICA 456, LIMA",                telefono: "976543210" },
  { nombre: "CARLOS",   paterno: "RAMIREZ",   correo: "CARLOS.RAMIREZ@CORREO.COM", direccion: "AV. JAVIER PRADO 789, SAN BORJA",           telefono: "965432109" },
  { nombre: "LUCIA",    paterno: "FLORES",    correo: "LUCIA.FLORES@CORREO.COM",   direccion: "CALLE LAS BEGONIAS 321, SAN ISIDRO",        telefono: "954321098" },
  { nombre: "PEDRO",    paterno: "MENDOZA",   correo: "PEDRO.MENDOZA@CORREO.COM",  direccion: "AV. TUPAC AMARU 654, COMAS",                telefono: "943210987" },
  { nombre: "ROSA",     paterno: "CASTILLO",  correo: "ROSA.CASTILLO@CORREO.COM",  direccion: "JR. AREQUIPA 987, LA VICTORIA",             telefono: "932109876" },
  { nombre: "LUIS",     paterno: "TORRES",    correo: "LUIS.TORRES@CORREO.COM",    direccion: "AV. ARGENTINA 147, CALLAO",                 telefono: "921098765" },
  { nombre: "ANA",      paterno: "GARCIA",    correo: "ANA.GARCIA@CORREO.COM",     direccion: "CALLE LOS PINOS 258, SURCO",                telefono: "910987654" },
  { nombre: "MIGUEL",   paterno: "SANCHEZ",   correo: "MIGUEL.SANCHEZ@CORREO.COM", direccion: "AV. PACHACUTEC 369, VILLA EL SALVADOR",     telefono: "999888777" },
  { nombre: "SOFIA",    paterno: "VARGAS",    correo: "SOFIA.VARGAS@CORREO.COM",   direccion: "AV. NICOLAS AYLLON 741, ATE",               telefono: "988777666" }
]);

print("Base " + dbName + " inicializada con " + appDb.clientes.countDocuments() + " clientes");