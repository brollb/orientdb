/* Generated By:JJTree: Do not edit this line. OExplainStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OBasicCommandContext;
import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.ODatabase;
import com.orientechnologies.orient.core.db.ODatabaseInternal;
import com.orientechnologies.orient.core.db.ODatabaseStats;
import com.orientechnologies.orient.core.exception.OCommandExecutionException;
import com.orientechnologies.orient.core.sql.executor.OExecutionPlan;
import com.orientechnologies.orient.core.sql.executor.OInternalExecutionPlan;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.orientechnologies.orient.core.sql.executor.OUpdateExecutionPlan;
import java.util.HashMap;
import java.util.Map;

public class OProfileStatement extends OStatement {

  protected OStatement statement;

  public OProfileStatement(int id) {
    super(id);
  }

  public OProfileStatement(OrientSql p, int id) {
    super(p, id);
  }

  @Override
  public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("PROFILE ");
    statement.toString(params, builder);
  }

  @Override
  public void toGenericStatement(StringBuilder builder) {
    builder.append("PROFILE ");
    statement.toGenericStatement(builder);
  }

  @Override
  public OResultSet execute(
      ODatabase db, Object[] args, OCommandContext parentCtx, boolean usePlanCache) {
    ((ODatabaseInternal) db).resetRecordLoadStats();
    OBasicCommandContext ctx = new OBasicCommandContext();
    if (parentCtx != null) {
      ctx.setParentWithoutOverridingChild(parentCtx);
    }
    ctx.setDatabase(db);
    Map<Object, Object> params = new HashMap<>();
    if (args != null) {
      for (int i = 0; i < args.length; i++) params.put(i, args[i]);
    }
    ctx.setInputParameters(params);

    OExecutionPlan executionPlan;
    if (usePlanCache) {
      executionPlan = statement.createExecutionPlan(ctx, true);
    } else {
      executionPlan = statement.createExecutionPlanNoCache(ctx, true);
    }

    if (executionPlan instanceof OUpdateExecutionPlan) {
      ((OUpdateExecutionPlan) executionPlan).executeInternal();
    }

    OLocalResultSet rs = new OLocalResultSet((OInternalExecutionPlan) executionPlan);

    while (rs.hasNext()) {
      rs.next();
    }
    ODatabaseStats dbStats = ((ODatabaseInternal) db).getStats();
    OExplainResultSet result =
        new OExplainResultSet(
            rs.getExecutionPlan()
                .orElseThrow(
                    () -> new OCommandExecutionException("Cannot profile command: " + statement)),
            dbStats);
    rs.close();
    return result;
  }

  @Override
  public OResultSet execute(
      ODatabase db, Map args, OCommandContext parentCtx, boolean usePlanCache) {
    ((ODatabaseInternal) db).resetRecordLoadStats();
    OBasicCommandContext ctx = new OBasicCommandContext();
    if (parentCtx != null) {
      ctx.setParentWithoutOverridingChild(parentCtx);
    }
    ctx.setDatabase(db);
    ctx.setInputParameters(args);

    OExecutionPlan executionPlan;
    if (usePlanCache) {
      executionPlan = statement.createExecutionPlan(ctx, true);
    } else {
      executionPlan = statement.createExecutionPlanNoCache(ctx, true);
    }

    OLocalResultSet rs = new OLocalResultSet((OInternalExecutionPlan) executionPlan);

    while (rs.hasNext()) {
      rs.next();
    }
    ODatabaseStats dbStats = ((ODatabaseInternal) db).getStats();
    OExplainResultSet result =
        new OExplainResultSet(
            rs.getExecutionPlan()
                .orElseThrow(
                    () -> new OCommandExecutionException("Cannot profile command: " + statement)),
            dbStats);
    rs.close();
    return result;
  }

  @Override
  public OInternalExecutionPlan createExecutionPlan(OCommandContext ctx, boolean profile) {
    return statement.createExecutionPlan(ctx, true);
  }

  @Override
  public OProfileStatement copy() {
    OProfileStatement result = new OProfileStatement(-1);
    result.statement = statement == null ? null : statement.copy();
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OProfileStatement that = (OProfileStatement) o;

    if (statement != null ? !statement.equals(that.statement) : that.statement != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return statement != null ? statement.hashCode() : 0;
  }

  @Override
  public boolean isIdempotent() {
    return true;
  }
}
/* JavaCC - OriginalChecksum=9fdd24510993cbee32e38a51c838bdb4 (do not edit this line) */
