package com.sample.criminaliintent

import java.util.Date
import java.util.UUID

class Crime(val id: UUID = UUID.randomUUID(), var title: String = "", var date: Date = Date(), var isSolved: Boolean = false) {
}