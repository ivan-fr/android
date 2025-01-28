package com.wayoukiss.android.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wayoukiss.android.data.local.converter.DateConverter;
import com.wayoukiss.android.data.local.converter.ListConverter;
import com.wayoukiss.android.data.local.converter.UUIDConverter;
import com.wayoukiss.android.data.local.entity.ProfileEntity;
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
public final class ProfileDao_Impl implements ProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProfileEntity> __insertionAdapterOfProfileEntity;

  private final UUIDConverter __uUIDConverter = new UUIDConverter();

  private final DateConverter __dateConverter = new DateConverter();

  private final ListConverter __listConverter = new ListConverter();

  private final SharedSQLiteStatement __preparedStmtOfDeleteProfileById;

  public ProfileDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProfileEntity = new EntityInsertionAdapter<ProfileEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `profiles` (`id`,`name`,`bio`,`birthDate`,`photos`,`lastActive`,`isOnline`,`location`,`interests`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProfileEntity entity) {
        final String _tmp = __uUIDConverter.uuidToString(entity.getId());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, _tmp);
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getBio() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBio());
        }
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getBirthDate());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_1);
        }
        final String _tmp_2 = __listConverter.fromList(entity.getPhotos());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_2);
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getLastActive());
        if (_tmp_3 == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp_3);
        }
        final int _tmp_4 = entity.isOnline() ? 1 : 0;
        statement.bindLong(7, _tmp_4);
        if (entity.getLocation() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLocation());
        }
        final String _tmp_5 = __listConverter.fromList(entity.getInterests());
        if (_tmp_5 == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmp_5);
        }
        final Long _tmp_6 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_6 == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, _tmp_6);
        }
        final Long _tmp_7 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_7 == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, _tmp_7);
        }
      }
    };
    this.__preparedStmtOfDeleteProfileById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM profiles WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertProfile(final ProfileEntity profile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProfileEntity.insert(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteProfileById(final String profileId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteProfileById.acquire();
        int _argIndex = 1;
        if (profileId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, profileId);
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
          __preparedStmtOfDeleteProfileById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getProfileById(final String profileId,
      final Continuation<? super ProfileEntity> $completion) {
    final String _sql = "SELECT * FROM profiles WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (profileId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, profileId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ProfileEntity>() {
      @Override
      @Nullable
      public ProfileEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBio = CursorUtil.getColumnIndexOrThrow(_cursor, "bio");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfLastActive = CursorUtil.getColumnIndexOrThrow(_cursor, "lastActive");
          final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfInterests = CursorUtil.getColumnIndexOrThrow(_cursor, "interests");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final ProfileEntity _result;
          if (_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBio;
            if (_cursor.isNull(_cursorIndexOfBio)) {
              _tmpBio = null;
            } else {
              _tmpBio = _cursor.getString(_cursorIndexOfBio);
            }
            final Date _tmpBirthDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __dateConverter.fromTimestamp(_tmp_1);
            final List<String> _tmpPhotos;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfPhotos);
            }
            _tmpPhotos = __listConverter.fromString(_tmp_2);
            final Date _tmpLastActive;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastActive)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastActive);
            }
            _tmpLastActive = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsOnline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOnline);
            _tmpIsOnline = _tmp_4 != 0;
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<String> _tmpInterests;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfInterests)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfInterests);
            }
            _tmpInterests = __listConverter.fromString(_tmp_5);
            final Date _tmpCreatedAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_6);
            final Date _tmpUpdatedAt;
            final Long _tmp_7;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_7);
            _result = new ProfileEntity(_tmpId,_tmpName,_tmpBio,_tmpBirthDate,_tmpPhotos,_tmpLastActive,_tmpIsOnline,_tmpLocation,_tmpInterests,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<ProfileEntity> observeProfileById(final String profileId) {
    final String _sql = "SELECT * FROM profiles WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (profileId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, profileId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"profiles"}, new Callable<ProfileEntity>() {
      @Override
      @Nullable
      public ProfileEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBio = CursorUtil.getColumnIndexOrThrow(_cursor, "bio");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfLastActive = CursorUtil.getColumnIndexOrThrow(_cursor, "lastActive");
          final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfInterests = CursorUtil.getColumnIndexOrThrow(_cursor, "interests");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final ProfileEntity _result;
          if (_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBio;
            if (_cursor.isNull(_cursorIndexOfBio)) {
              _tmpBio = null;
            } else {
              _tmpBio = _cursor.getString(_cursorIndexOfBio);
            }
            final Date _tmpBirthDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __dateConverter.fromTimestamp(_tmp_1);
            final List<String> _tmpPhotos;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfPhotos);
            }
            _tmpPhotos = __listConverter.fromString(_tmp_2);
            final Date _tmpLastActive;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastActive)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastActive);
            }
            _tmpLastActive = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsOnline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOnline);
            _tmpIsOnline = _tmp_4 != 0;
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<String> _tmpInterests;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfInterests)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfInterests);
            }
            _tmpInterests = __listConverter.fromString(_tmp_5);
            final Date _tmpCreatedAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_6);
            final Date _tmpUpdatedAt;
            final Long _tmp_7;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_7);
            _result = new ProfileEntity(_tmpId,_tmpName,_tmpBio,_tmpBirthDate,_tmpPhotos,_tmpLastActive,_tmpIsOnline,_tmpLocation,_tmpInterests,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
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
  public Flow<List<ProfileEntity>> observeAllProfiles() {
    final String _sql = "SELECT * FROM profiles";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"profiles"}, new Callable<List<ProfileEntity>>() {
      @Override
      @NonNull
      public List<ProfileEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBio = CursorUtil.getColumnIndexOrThrow(_cursor, "bio");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfLastActive = CursorUtil.getColumnIndexOrThrow(_cursor, "lastActive");
          final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfInterests = CursorUtil.getColumnIndexOrThrow(_cursor, "interests");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<ProfileEntity> _result = new ArrayList<ProfileEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProfileEntity _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBio;
            if (_cursor.isNull(_cursorIndexOfBio)) {
              _tmpBio = null;
            } else {
              _tmpBio = _cursor.getString(_cursorIndexOfBio);
            }
            final Date _tmpBirthDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __dateConverter.fromTimestamp(_tmp_1);
            final List<String> _tmpPhotos;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfPhotos);
            }
            _tmpPhotos = __listConverter.fromString(_tmp_2);
            final Date _tmpLastActive;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastActive)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastActive);
            }
            _tmpLastActive = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsOnline;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsOnline);
            _tmpIsOnline = _tmp_4 != 0;
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<String> _tmpInterests;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfInterests)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfInterests);
            }
            _tmpInterests = __listConverter.fromString(_tmp_5);
            final Date _tmpCreatedAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_6);
            final Date _tmpUpdatedAt;
            final Long _tmp_7;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_7);
            _item = new ProfileEntity(_tmpId,_tmpName,_tmpBio,_tmpBirthDate,_tmpPhotos,_tmpLastActive,_tmpIsOnline,_tmpLocation,_tmpInterests,_tmpCreatedAt,_tmpUpdatedAt);
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
