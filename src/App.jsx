import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DashboardLayout from './layouts/DashboardLayout';
import Dashboard from './pages/Dashboard';
import Vendors from './pages/Vendors';
import Procurement from './pages/Procurement';
import Inventory from './pages/Inventory';
import Invoices from './pages/Invoices';
import Approvals from './pages/Approvals';

// Placeholder components for routing
const Placeholder = ({ title }) => (
  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100%', color: 'var(--text-secondary)' }}>
    <h2>{title} Page - Coming Soon</h2>
  </div>
);

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<DashboardLayout />}>
          <Route index element={<Dashboard />} />
          <Route path="vendors" element={<Vendors />} />
          <Route path="procurement" element={<Procurement />} />
          <Route path="inventory" element={<Inventory />} />
          <Route path="invoices" element={<Invoices />} />
          <Route path="payments" element={<Invoices />} />
          <Route path="approvals" element={<Approvals />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
