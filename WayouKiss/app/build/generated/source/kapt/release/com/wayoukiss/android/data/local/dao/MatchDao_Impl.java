package com.wayoukiss.android.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wayoukiss.android.data.local.converter.DateConverter;
import com.wayoukiss.android.data.local.converter.UUIDConverter;
import com.wayoukiss.android.data.local.entity.MatchEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MatchDao_Impl implements MatchDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMatch;

  private final UUIDConverter __uUIDConverter = new UUIDConverter();

  private final DateConverter __dateConverter = new DateConverter();

  public MatchDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfDeleteMatch = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM matches WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object deleteMatch(final UUID matchId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMatch.acquire();
        int _argIndex = 1;
        final String _tmp = __uUIDConverter.uuidToString(matchId);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteMatch.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MatchEntity>> getMatches(final UUID userId) {
    final String _sql = "\n"
            + "        SELECT * FROM matches \n"
            + "        WHERE user1Id = ? OR user2Id = ? \n"
            + "        ORDER BY matchedAt DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __uUIDConverter.uuidToString(userId);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __uUIDConverter.uuidToString(userId);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"matches"}, new Callable<List<MatchEntity>>() {
      @Override
      @NonNull
      public List<MatchEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUser1Id = CursorUtil.getColumnIndexOrThrow(_cursor, "user1Id");
          final int _cursorIndexOfUser2Id = CursorUtil.getColumnIndexOrThrow(_cursor, "user2Id");
          final int _cursorIndexOfMatchedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "matchedAt");
          final int _cursorIndexOfLastInteractionAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastInteractionAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<MatchEntity> _result = new ArrayList<MatchEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MatchEntity _item;
            final UUID _tmpId;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp_2);
            final UUID _tmpUser1Id;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfUser1Id)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfUser1Id);
            }
            _tmpUser1Id = __uUIDConverter.fromString(_tmp_3);
            final UUID _tmpUser2Id;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUser2Id)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUser2Id);
            }
            _tmpUser2Id = __uUIDConverter.fromString(_tmp_4);
            final Date _tmpMatchedAt;
            final Long _tmp_5;
            if (_cursor.isNull(_cursorIndexOfMatchedAt)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getLong(_cursorIndexOfMatchedAt);
            }
            _tmpMatchedAt = __dateConverter.fromTimestamp(_tmp_5);
            final Date _tmpLastInteractionAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfLastInteractionAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfLastInteractionAt);
            }
            _tmpLastInteractionAt = __dateConverter.fromTimestamp(_tmp_6);
            final boolean _tmpIsActive;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_7 != 0;
            _item = new MatchEntity(_tmpId,_tmpUser1Id,_tmpUser2Id,_tmpMatchedAt,_tmpLastInteractionAt,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<MatchEntity>> getMatchesByStatus(final UUID userId, final boolean isActive) {
    final String _sql = "\n"
            + "        SELECT * FROM matches \n"
            + "        WHERE (user1Id = ? OR user2Id = ?) \n"
            + "        AND isActive = ? \n"
            + "        ORDER BY matchedAt DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    final String _tmp = __uUIDConverter.uuidToString(userId);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __uUIDConverter.uuidToString(userId);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    _argIndex = 3;
    final int _tmp_2 = isActive ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp_2);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"matches"}, new Callable<List<MatchEntity>>() {
      @Override
      @NonNull
      public List<MatchEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUser1Id = CursorUtil.getColumnIndexOrThrow(_cursor, "user1Id");
          final int _cursorIndexOfUser2Id = CursorUtil.getColumnIndexOrThrow(_cursor, "user2Id");
          final int _cursorIndexOfMatchedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "matchedAt");
          final int _cursorIndexOfLastInteractionAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastInteractionAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<MatchEntity> _result = new ArrayList<MatchEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MatchEntity _item;
            final UUID _tmpId;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp_3);
            final UUID _tmpUser1Id;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUser1Id)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfUser1Id);
            }
            _tmpUser1Id = __uUIDConverter.fromString(_tmp_4);
            final UUID _tmpUser2Id;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfUser2Id)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfUser2Id);
            }
            _tmpUser2Id = __uUIDConverter.fromString(_tmp_5);
            final Date _tmpMatchedAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfMatchedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfMatchedAt);
            }
            _tmpMatchedAt = __dateConverter.fromTimestamp(_tmp_6);
            final Date _tmpLastInteractionAt;
            final Long _tmp_7;
            if (_cursor.isNull(_cursorIndexOfLastInteractionAt)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getLong(_cursorIndexOfLastInteractionAt);
            }
            _tmpLastInteractionAt = __dateConverter.fromTimestamp(_tmp_7);
            final boolean _tmpIsActive;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_8 != 0;
            _item = new MatchEntity(_tmpId,_tmpUser1Id,_tmpUser2Id,_tmpMatchedAt,_tmpLastInteractionAt,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
