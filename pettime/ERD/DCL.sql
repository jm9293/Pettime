--drop user pettime CASCADE;

CREATE user pettime IDENTIFIED by pettime1234;
grant CONNECT, RESOURCE, create VIEW to pettime;