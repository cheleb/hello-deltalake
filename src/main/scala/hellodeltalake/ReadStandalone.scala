package hellodeltalake

import io.delta.standalone.Snapshot
import io.delta.standalone.DeltaLog
import org.apache.hadoop.conf.Configuration
import io.delta.standalone.expressions.And
import io.delta.standalone.expressions.EqualTo
import io.delta.standalone.expressions.Literal

import scala.jdk.CollectionConverters._

object ReadStandalone extends App {

  val log = DeltaLog.forTable(new Configuration(), "/tmp/delta-table");
  val snapshot = log.snapshot()

  val it = snapshot.open()

 val sum = it.asScala.foldLeft(0l){
    case (acc, record) => acc + record.getLong("id")
  }

  println(sum)


  /*
  val latestSnapshot = log.update();
  val schema = latestSnapshot.getMetadata().getSchema();
  println(schema.toPrettyJson())
  schema.getFields().foreach(f => println(f.getName()))
  val scanAll = latestSnapshot.scan()

  val iterator = scanAll.getFiles()
  println(iterator.hasNext())
  iterator.forEachRemaining(f => println(f.getPath()))

  sys.exit()
  val scan = latestSnapshot.scan(
    new And(
      new And(new EqualTo(schema.column("year"), Literal.of(2021)),
              new EqualTo(schema.column("month"), Literal.of(11))
      ),
      new EqualTo(schema.column("customer"), Literal.of("XYZ"))
    )
  );

  val iter = scan.getFiles();

  try while (iter.hasNext()) {
    val addFile = iter.next();
    Zappy

    // Zappy engine to handle reading data in `addFile.getPath()` and apply any `scan.getResidualPredicate()`
  } finally iter.close();
  */
}
