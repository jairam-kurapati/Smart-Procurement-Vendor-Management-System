import { Bell, Search, UserCircle } from 'lucide-react';
import './Header.css';

export default function Header() {
  return (
    <header className="header glass-header">
      <div className="header-search">
        <Search className="search-icon" size={20} />
        <input 
          type="text" 
          placeholder="Search vendors, POs, or items..." 
          className="search-input"
        />
      </div>
      
      <div className="header-actions">
        <button className="icon-btn">
          <Bell size={20} />
          <span className="notification-dot"></span>
        </button>
        <div className="user-profile">
          <div className="user-info">
            <span className="user-name">Admin User</span>
            <span className="user-role">System Administrator</span>
          </div>
          <UserCircle size={36} className="avatar-icon" />
        </div>
      </div>
    </header>
  );
}
