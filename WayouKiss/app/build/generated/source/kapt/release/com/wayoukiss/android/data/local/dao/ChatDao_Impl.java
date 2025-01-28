package com.wayoukiss.android.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wayoukiss.android.data.local.converter.DateConverter;
import com.wayoukiss.android.data.local.converter.UUIDConverter;
import com.wayoukiss.android.data.local.entity.ChatEntity;
import com.wayoukiss.android.data.local.entity.ChatWithMessages;
import com.wayoukiss.android.data.local.entity.MessageEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChatEntity> __insertionAdapterOfChatEntity;

  private final UUIDConverter __uUIDConverter = new UUIDConverter();

  private final DateConverter __dateConverter = new DateConverter();

  private final SharedSQLiteStatement __preparedStmtOfDeleteChatById;

  public ChatDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChatEntity = new EntityInsertionAdapter<ChatEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `chats` (`id`,`matchId`,`lastMessageAt`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChatEntity entity) {
        final String _tmp = __uUIDConverter.uuidToString(entity.getId());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, _tmp);
        }
        final String _tmp_1 = __uUIDConverter.uuidToString(entity.getMatchId());
        if (_tmp_1 == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getLastMessageAt());
        if (_tmp_2 == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp_2);
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_3 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_3);
        }
        final Long _tmp_4 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_4 == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp_4);
        }
      }
    };
    this.__preparedStmtOfDeleteChatById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM chats WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertChat(final ChatEntity chat, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChatEntity.insert(chat);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteChatById(final String chatId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteChatById.acquire();
        int _argIndex = 1;
        if (chatId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, chatId);
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
          __preparedStmtOfDeleteChatById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ChatEntity>> observeAllChats() {
    final String _sql = "SELECT * FROM chats";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"chats"}, new Callable<List<ChatEntity>>() {
      @Override
      @NonNull
      public List<ChatEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "matchId");
          final int _cursorIndexOfLastMessageAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageAt");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<ChatEntity> _result = new ArrayList<ChatEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ChatEntity _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final UUID _tmpMatchId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMatchId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfMatchId);
            }
            _tmpMatchId = __uUIDConverter.fromString(_tmp_1);
            final Date _tmpLastMessageAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastMessageAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastMessageAt);
            }
            _tmpLastMessageAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpCreatedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_3);
            final Date _tmpUpdatedAt;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_4);
            _item = new ChatEntity(_tmpId,_tmpMatchId,_tmpLastMessageAt,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getChatById(final String chatId,
      final Continuation<? super ChatEntity> $completion) {
    final String _sql = "SELECT * FROM chats WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ChatEntity>() {
      @Override
      @Nullable
      public ChatEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "matchId");
          final int _cursorIndexOfLastMessageAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageAt");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final ChatEntity _result;
          if (_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final UUID _tmpMatchId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMatchId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfMatchId);
            }
            _tmpMatchId = __uUIDConverter.fromString(_tmp_1);
            final Date _tmpLastMessageAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastMessageAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastMessageAt);
            }
            _tmpLastMessageAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpCreatedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_3);
            final Date _tmpUpdatedAt;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_4);
            _result = new ChatEntity(_tmpId,_tmpMatchId,_tmpLastMessageAt,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<ChatWithMessages>> observeChatsWithRecentMessages(final long timestamp) {
    final String _sql = "\n"
            + "        SELECT c.* FROM chats c \n"
            + "        INNER JOIN messages m ON c.id = m.chatId \n"
            + "        WHERE m.timestamp > ?\n"
            + "        GROUP BY c.id\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, timestamp);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"messages",
        "chats"}, new Callable<List<ChatWithMessages>>() {
      @Override
      @NonNull
      public List<ChatWithMessages> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "matchId");
            final int _cursorIndexOfLastMessageAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageAt");
            final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
            final ArrayMap<String, ArrayList<MessageEntity>> _collectionMessages = new ArrayMap<String, ArrayList<MessageEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey = null;
              } else {
                _tmpKey = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey != null) {
                if (!_collectionMessages.containsKey(_tmpKey)) {
                  _collectionMessages.put(_tmpKey, new ArrayList<MessageEntity>());
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipmessagesAscomWayoukissAndroidDataLocalEntityMessageEntity(_collectionMessages);
            final List<ChatWithMessages> _result = new ArrayList<ChatWithMessages>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final ChatWithMessages _item;
              final ChatEntity _tmpChat;
              final UUID _tmpId;
              final String _tmp;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmp = null;
              } else {
                _tmp = _cursor.getString(_cursorIndexOfId);
              }
              _tmpId = __uUIDConverter.fromString(_tmp);
              final UUID _tmpMatchId;
              final String _tmp_1;
              if (_cursor.isNull(_cursorIndexOfMatchId)) {
                _tmp_1 = null;
              } else {
                _tmp_1 = _cursor.getString(_cursorIndexOfMatchId);
              }
              _tmpMatchId = __uUIDConverter.fromString(_tmp_1);
              final Date _tmpLastMessageAt;
              final Long _tmp_2;
              if (_cursor.isNull(_cursorIndexOfLastMessageAt)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getLong(_cursorIndexOfLastMessageAt);
              }
              _tmpLastMessageAt = __dateConverter.fromTimestamp(_tmp_2);
              final Date _tmpCreatedAt;
              final Long _tmp_3;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
              }
              _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_3);
              final Date _tmpUpdatedAt;
              final Long _tmp_4;
              if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
              }
              _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_4);
              _tmpChat = new ChatEntity(_tmpId,_tmpMatchId,_tmpLastMessageAt,_tmpCreatedAt,_tmpUpdatedAt);
              final ArrayList<MessageEntity> _tmpMessagesCollection;
              final String _tmpKey_1;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey_1 = null;
              } else {
                _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey_1 != null) {
                _tmpMessagesCollection = _collectionMessages.get(_tmpKey_1);
              } else {
                _tmpMessagesCollection = new ArrayList<MessageEntity>();
              }
              _item = new ChatWithMessages(_tmpChat,_tmpMessagesCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ChatWithMessages>> observeChatsWithMessages() {
    final String _sql = "\n"
            + "        SELECT c.* FROM chats c \n"
            + "        LEFT JOIN messages m ON c.id = m.chatId \n"
            + "        GROUP BY c.id\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"messages",
        "chats"}, new Callable<List<ChatWithMessages>>() {
      @Override
      @NonNull
      public List<ChatWithMessages> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "matchId");
            final int _cursorIndexOfLastMessageAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageAt");
            final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
            final ArrayMap<String, ArrayList<MessageEntity>> _collectionMessages = new ArrayMap<String, ArrayList<MessageEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey = null;
              } else {
                _tmpKey = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey != null) {
                if (!_collectionMessages.containsKey(_tmpKey)) {
                  _collectionMessages.put(_tmpKey, new ArrayList<MessageEntity>());
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipmessagesAscomWayoukissAndroidDataLocalEntityMessageEntity(_collectionMessages);
            final List<ChatWithMessages> _result = new ArrayList<ChatWithMessages>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final ChatWithMessages _item;
              final ChatEntity _tmpChat;
              final UUID _tmpId;
              final String _tmp;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmp = null;
              } else {
                _tmp = _cursor.getString(_cursorIndexOfId);
              }
              _tmpId = __uUIDConverter.fromString(_tmp);
              final UUID _tmpMatchId;
              final String _tmp_1;
              if (_cursor.isNull(_cursorIndexOfMatchId)) {
                _tmp_1 = null;
              } else {
                _tmp_1 = _cursor.getString(_cursorIndexOfMatchId);
              }
              _tmpMatchId = __uUIDConverter.fromString(_tmp_1);
              final Date _tmpLastMessageAt;
              final Long _tmp_2;
              if (_cursor.isNull(_cursorIndexOfLastMessageAt)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getLong(_cursorIndexOfLastMessageAt);
              }
              _tmpLastMessageAt = __dateConverter.fromTimestamp(_tmp_2);
              final Date _tmpCreatedAt;
              final Long _tmp_3;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = _cursor.getLong(_cursorIndexOfCreatedAt);
              }
              _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_3);
              final Date _tmpUpdatedAt;
              final Long _tmp_4;
              if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = _cursor.getLong(_cursorIndexOfUpdatedAt);
              }
              _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_4);
              _tmpChat = new ChatEntity(_tmpId,_tmpMatchId,_tmpLastMessageAt,_tmpCreatedAt,_tmpUpdatedAt);
              final ArrayList<MessageEntity> _tmpMessagesCollection;
              final String _tmpKey_1;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey_1 = null;
              } else {
                _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey_1 != null) {
                _tmpMessagesCollection = _collectionMessages.get(_tmpKey_1);
              } else {
                _tmpMessagesCollection = new ArrayList<MessageEntity>();
              }
              _item = new ChatWithMessages(_tmpChat,_tmpMessagesCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
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

  private void __fetchRelationshipmessagesAscomWayoukissAndroidDataLocalEntityMessageEntity(
      @NonNull final ArrayMap<String, ArrayList<MessageEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, true, (map) -> {
        __fetchRelationshipmessagesAscomWayoukissAndroidDataLocalEntityMessageEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`chatId`,`senderId`,`content`,`timestamp`,`isRead`,`createdAt`,`updatedAt` FROM `messages` WHERE `chatId` IN (");
    final int _inputSize = __mapKeySet == null ? 1 : __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (__mapKeySet == null) {
      _stmt.bindNull(_argIndex);
    } else {
      for (String _item : __mapKeySet) {
        if (_item == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _item);
        }
        _argIndex++;
      }
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "chatId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfChatId = 1;
      final int _cursorIndexOfSenderId = 2;
      final int _cursorIndexOfContent = 3;
      final int _cursorIndexOfTimestamp = 4;
      final int _cursorIndexOfIsRead = 5;
      final int _cursorIndexOfCreatedAt = 6;
      final int _cursorIndexOfUpdatedAt = 7;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        if (_cursor.isNull(_itemKeyIndex)) {
          _tmpKey = null;
        } else {
          _tmpKey = _cursor.getString(_itemKeyIndex);
        }
        if (_tmpKey != null) {
          final ArrayList<MessageEntity> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final MessageEntity _item_1;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __uUIDConverter.fromString(_tmp);
            final UUID _tmpChatId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfChatId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfChatId);
            }
            _tmpChatId = __uUIDConverter.fromString(_tmp_1);
            final UUID _tmpSenderId;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSenderId);
            }
            _tmpSenderId = __uUIDConverter.fromString(_tmp_2);
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final Date _tmpTimestamp;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsRead;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp_4 != 0;
            final Date _tmpCreatedAt;
            final Long _tmp_5;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_5);
            final Date _tmpUpdatedAt;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_6);
            _item_1 = new MessageEntity(_tmpId,_tmpChatId,_tmpSenderId,_tmpContent,_tmpTimestamp,_tmpIsRead,_tmpCreatedAt,_tmpUpdatedAt);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
